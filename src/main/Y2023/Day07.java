package main.Y2023;

import main.IDay;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Day07 implements IDay {

    private static final String CARD_RANK_PART_1 = "AKQJT98765432";

    private static final String CARD_RANK_PART_2 = "AKQT98765432J";

    record CardHand(String cards, int value) {

        public int compare(CardHand handToCompare, String cardRank) {
            String cardsToCompare = handToCompare.cards();
            for (int i = 0; i < Math.min(cards.length(), cardsToCompare.length()); i++) {
                int rankComparison = Integer.compare(cardRank.indexOf(cards.charAt(i)), cardRank.indexOf(cardsToCompare.charAt(i)));
                if (rankComparison != 0) {
                    return rankComparison;
                }
            }

            // If the cards have the same prefix, compare based on the value
            return Integer.compare(value, handToCompare.value());
        }

        public int comparePart1(CardHand hand) {
            return this.compare(hand, CARD_RANK_PART_1);
        }

        public int comparePart2(CardHand hand) {
            return this.compare(hand, CARD_RANK_PART_2);
        }
    }


    @Override
    public String solvePart1(List<String> input) {
        List<CardHand> cardHands = input.stream().map(line -> {
                    String[] parts = line.split(" ");
                    return new CardHand(parts[0], Integer.parseInt(parts[1]));
                })
                .toList();

        var fiveC = new ArrayList<CardHand>();
        var fourC = new ArrayList<CardHand>();
        var house = new ArrayList<CardHand>();
        var threeC = new ArrayList<CardHand>();
        var twoPair = new ArrayList<CardHand>();
        var pair = new ArrayList<CardHand>();
        var highC = new ArrayList<CardHand>();

        for (CardHand cardHand : cardHands) {
            Map<Character, Long> occurrences = cardHand.cards().chars()
                    .mapToObj(c -> (char) c)
                    .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

            if (countPairs(occurrences, 5) == 1) { // Five of a kind
                fiveC.add(cardHand);
            } else if (countPairs(occurrences, 4) == 1) { // Four of a kind
                fourC.add(cardHand);
            } else if (occurrences.size() == 2) { // Full house
                house.add(cardHand);
            } else if (countPairs(occurrences, 3) > 0) { // Three of a kind
                threeC.add(cardHand);
            } else if (countPairs(occurrences, 2) > 1) { // Two Pairs
                twoPair.add(cardHand);
            } else if (countPairs(occurrences, 2) > 0) { // Pair
                pair.add(cardHand);
            } else { // High Card
                highC.add(cardHand);
            }
        }

        fiveC.sort(CardHand::comparePart1);
        fourC.sort(CardHand::comparePart1);
        house.sort(CardHand::comparePart1);
        threeC.sort(CardHand::comparePart1);
        twoPair.sort(CardHand::comparePart1);
        pair.sort(CardHand::comparePart1);
        highC.sort(CardHand::comparePart1);


        var finalList = new ArrayList<CardHand>();
        finalList.addAll(fiveC);
        finalList.addAll(fourC);
        finalList.addAll(house);
        finalList.addAll(threeC);
        finalList.addAll(twoPair);
        finalList.addAll(pair);
        finalList.addAll(highC);


        var result = 0;
        var num = finalList.size();
        for (var hand : finalList) {
            result += hand.value() * num;
            num--;
        }
        return String.valueOf(result);
    }

    private long countPairs(Map<Character, Long> cardOccurrences, long numOfSame) {
        long pairCount = 0;

        for (long count : cardOccurrences.values()) {
            if (count == numOfSame) {
                pairCount++;
            }
        }
        return pairCount;
    }

    private long countPairs2(Map<Character, Long> cardOccurrences, long numOfSame) {
        long pairCount = 0;
        var numOfJokers = cardOccurrences.getOrDefault('J', 0L);
        var numJokersLeft = numOfJokers;
        cardOccurrences.remove('J');

        for (long count : cardOccurrences.values()) {
            if (count + numJokersLeft >= numOfSame) {
                numJokersLeft -= numOfSame - count;
                pairCount++;
            }
        }
        if (cardOccurrences.values().isEmpty() && numJokersLeft == numOfSame) {
            pairCount++;
        }
        cardOccurrences.put('J', numOfJokers);
        return pairCount;
    }

    @Override
    public String solvePart2(List<String> input) {
        List<CardHand> cardHands = input.stream().map(line -> {
                    String[] parts = line.split(" ");
                    return new CardHand(parts[0], Integer.parseInt(parts[1]));
                })
                .toList();

        var fiveC = new ArrayList<CardHand>();
        var fourC = new ArrayList<CardHand>();
        var house = new ArrayList<CardHand>();
        var threeC = new ArrayList<CardHand>();
        var twoPair = new ArrayList<CardHand>();
        var pair = new ArrayList<CardHand>();
        var highC = new ArrayList<CardHand>();

        for (CardHand cardHand : cardHands) {
            Map<Character, Long> occurrences = cardHand.cards().chars()
                    .mapToObj(c -> (char) c)
                    .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

            if (countPairs2(occurrences, 5) == 1) { // Five of a kind
                fiveC.add(cardHand);
            } else if (countPairs2(occurrences, 4) == 1) { // Four of a kind
                fourC.add(cardHand);
            } else if (occurrences.size() == 2 || (occurrences.size() == 3 && occurrences.get('J') != null)) { // Full house
                house.add(cardHand);
            } else if (countPairs2(occurrences, 3) > 0) { // Three of a kind
                threeC.add(cardHand);
            } else if (countPairs2(occurrences, 2) > 1) { // Two Pairs
                twoPair.add(cardHand);
            } else if (countPairs2(occurrences, 2) > 0) { // Pair
                pair.add(cardHand);
            } else { // High Card
                highC.add(cardHand);
            }
        }

        fiveC.sort(CardHand::comparePart2);
        fourC.sort(CardHand::comparePart2);
        house.sort(CardHand::comparePart2);
        threeC.sort(CardHand::comparePart2);
        twoPair.sort(CardHand::comparePart2);
        pair.sort(CardHand::comparePart2);
        highC.sort(CardHand::comparePart2);

        var finalList = new ArrayList<CardHand>();
        finalList.addAll(fiveC);
        finalList.addAll(fourC);
        finalList.addAll(house);
        finalList.addAll(threeC);
        finalList.addAll(twoPair);
        finalList.addAll(pair);
        finalList.addAll(highC);
        
        var result = 0;
        var num = finalList.size();
        for (var hand : finalList) {
            result += hand.value() * num;
            num--;
        }
        return String.valueOf(result);
    }
}
