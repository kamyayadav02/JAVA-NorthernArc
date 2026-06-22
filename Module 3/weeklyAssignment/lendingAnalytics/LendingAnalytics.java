package org.northernarc.weeklyassignment;

import java.util.*;
import java.util.stream.Collectors;

public class LendingAnalytics {

    private Map<String, LoanApplication> applications = new HashMap<>();

    public void loadApplications(List<String> records) {

        if (records == null) {
            return;
        }

        for (String record : records) {

            if (record == null || record.trim().isEmpty()) {
                continue;
            }

            StringTokenizer st = new StringTokenizer(record, "|");

            if (st.countTokens() != 6) {
                continue;
            }

            String applicationId = st.nextToken().trim();
            String customerName = st.nextToken().trim();
            String lenderName = st.nextToken().trim();
            String loanType = st.nextToken().trim();

            double loanAmount;
            int creditScore;

            try {
                loanAmount = Double.parseDouble(st.nextToken().trim());
                creditScore = Integer.parseInt(st.nextToken().trim());
            }
            catch (NumberFormatException e) {
                continue;
            }

            if (applicationId.isEmpty() || customerName.isEmpty() || lenderName.isEmpty() || loanType.isEmpty() || loanAmount <= 0 || creditScore < 300 || creditScore > 900) {
                continue;
            }

            LoanApplication newApplication = new LoanApplication(applicationId, customerName, lenderName, loanType, loanAmount, creditScore);

            LoanApplication existingApplication = applications.get(applicationId);

            if (existingApplication == null) {

                applications.put(applicationId, newApplication);
                continue;
            }

            if (newApplication.getCreditScore() > existingApplication.getCreditScore()) {
                applications.put(applicationId, newApplication);
            }

            else if (newApplication.getCreditScore() == existingApplication.getCreditScore()) {

                if (newApplication.getLoanAmount()
                        < existingApplication.getLoanAmount()) {

                    applications.put(applicationId, newApplication);
                }

                else if (newApplication.getLoanAmount()
                        == existingApplication.getLoanAmount()) {

                    if (newApplication.getCustomerName()
                            .compareTo(existingApplication.getCustomerName()) < 0) {

                        applications.put(applicationId, newApplication);
                    }
                }
            }
        }
    }
    public List<LoanApplication> topCreditProfiles(int n) {

        List<LoanApplication> applicationList = new ArrayList<>(applications.values());

        applicationList.sort(Comparator.comparingInt(LoanApplication::getCreditScore)
                        .reversed()
                        .thenComparingDouble(LoanApplication::getLoanAmount)
                        .thenComparing(LoanApplication::getCustomerName)
        );

        return applicationList.stream()
                .limit(n)
                .toList();
    }
    public Map<String, Double> averageLoanAmountByType() {

        Map<String, Double> result = new TreeMap<>();

        applications.values().stream().collect(
                        Collectors.groupingBy(
                                LoanApplication::getLoanType,
                                Collectors.averagingDouble(
                                        LoanApplication::getLoanAmount
                                )
                        )
                )
                .forEach((loanType, average) -> result.put(
                                        loanType,
                                        Math.round(average * 100.0) / 100.0));

        return result;
    }
    public Optional<LoanApplication> highestLoanApplication() {

        Comparator<LoanApplication> comparator =
                Comparator.comparingDouble(LoanApplication::getLoanAmount)
                        .thenComparingInt(LoanApplication::getCreditScore)
                        .thenComparing(
                                LoanApplication::getApplicationId,
                                Comparator.reverseOrder()
                        );

        return applications.values()
                .stream()
                .max(comparator);
    }
    public Set<String> lendersWithMultipleLoanTypes() {

        Set<String> result = new TreeSet<>();

        applications.values().stream().collect(
                        Collectors.groupingBy(LoanApplication::getLenderName, Collectors.mapping(
                                        LoanApplication::getLoanType,
                                        Collectors.toSet()
                                )
                        )
                )
                .forEach((lender, loanTypes) -> {

                    if (loanTypes.size() > 1) {
                        result.add(lender);
                    }
                });

        return result;
    }
    public Map<String, List<LoanApplication>> groupApplicationsByLender() {

        TreeMap<String, List<LoanApplication>> groupedApplications =
                new TreeMap<>();

        for (LoanApplication application : applications.values()) {

            groupedApplications.computeIfAbsent(
                            application.getLenderName(),
                            k -> new ArrayList<>()
                    ).add(application);
        }

        LinkedHashMap<String, List<LoanApplication>> result = new LinkedHashMap<>();

        for (Map.Entry<String, List<LoanApplication>> entry : groupedApplications.entrySet()) {

            List<LoanApplication> applicationList = new ArrayList<>(entry.getValue());

            applicationList.sort(Comparator.comparingInt(LoanApplication::getCreditScore)
                            .reversed()
                            .thenComparingDouble(LoanApplication::getLoanAmount)
            );

            result.put(entry.getKey(), applicationList);
        }

        return result;
    }
    public List<String> suspiciousApplications() {

        Set<String> suspicious = new TreeSet<>();

        Map<String, Double> avgLoanAmountByType =
                applications.values().stream()
                        .collect(Collectors.groupingBy(
                                LoanApplication::getLoanType,
                                Collectors.averagingDouble(
                                        LoanApplication::getLoanAmount)));

        Map<String, Double> avgCreditScoreByType =
                applications.values().stream()
                        .collect(Collectors.groupingBy(
                                LoanApplication::getLoanType,
                                Collectors.averagingInt(
                                        LoanApplication::getCreditScore)));

        Map<String, Set<String>> lendersByCustomer =
                applications.values().stream()
                        .collect(Collectors.groupingBy(
                                a -> a.getCustomerName().toLowerCase(),
                                Collectors.mapping(
                                        LoanApplication::getLenderName,
                                        Collectors.toSet()
                                )));
        // Condition 1
        applications.values().stream()
                .filter(a -> {StringTokenizer st = new StringTokenizer(a.getCustomerName());

                    List<String> words = new ArrayList<>();

                    while (st.hasMoreTokens()) {
                        words.add(st.nextToken());
                    }

                    for (int i = 0; i < words.size() - 1; i++) {

                        if (words.get(i)
                                .equalsIgnoreCase(words.get(i + 1))) {

                            return true;
                        }
                    }

                    return false;
                })
                .map(LoanApplication::getCustomerName)
                .forEach(suspicious::add);

        // Condition 2
        applications.values().stream().filter(a -> a.getCustomerName().toLowerCase()
                                .contains(a.getLenderName().toLowerCase()))
                .map(LoanApplication::getCustomerName)
                .forEach(suspicious::add);

        // Condition 3
        applications.values().stream()
                .filter(a -> {

                    double avg =
                            avgLoanAmountByType.get(a.getLoanType());

                    return avg > 0 &&
                            a.getLoanAmount() > 2.5 * avg;
                })
                .map(LoanApplication::getCustomerName)
                .forEach(suspicious::add);

        // Condition 4
        applications.values().stream()
                .filter(a ->
                        a.getCreditScore()
                                < avgCreditScoreByType.get(a.getLoanType())
                                &&
                                a.getLoanAmount()
                                        > avgLoanAmountByType.get(a.getLoanType()))
                .map(LoanApplication::getCustomerName)
                .forEach(suspicious::add);

        // Condition 5
        applications.values().stream()
                .filter(a -> {

                    StringTokenizer st =
                            new StringTokenizer(a.getCustomerName());

                    return st.countTokens() > 3;
                })
                .map(LoanApplication::getCustomerName)
                .forEach(suspicious::add);

        // Condition 6
        applications.values().stream()
                .filter(a ->
                        lendersByCustomer
                                .get(a.getCustomerName().toLowerCase())
                                .size() > 3)
                .map(LoanApplication::getCustomerName)
                .forEach(suspicious::add);
        // Condition 7
        applications.values().stream()
                .collect(Collectors.groupingBy(
                        a -> a.getLoanType() + "|"
                                + a.getLoanAmount() + "|"
                                + a.getCreditScore()))
                .values()
                .stream()
                .filter(group ->
                        group.stream()
                                .map(LoanApplication::getCustomerName)
                                .distinct()
                                .count() > 1)
                .flatMap(List::stream)
                .map(LoanApplication::getCustomerName)
                .forEach(suspicious::add);
//condition 8
        applications.values().stream()
                .collect(Collectors.groupingBy(
                        a -> {

                            List<String> words =
                                    new ArrayList<>();

                            StringTokenizer st =
                                    new StringTokenizer(
                                            a.getCustomerName()
                                                    .toLowerCase());

                            while (st.hasMoreTokens()) {
                                words.add(st.nextToken());
                            }

                            Collections.sort(words);

                            String key =
                                    String.join(" ", words);

                            return a.getLenderName()
                                    .toLowerCase()
                                    + "|" + key;
                        }))
                .values()
                .stream()
                .filter(group -> group.size() > 1)
                .flatMap(List::stream)
                .map(LoanApplication::getCustomerName)
                .forEach(suspicious::add);

        return new ArrayList<>(suspicious);
    }
}
