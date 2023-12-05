package main.Y2023;

import main.IDay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day05 implements IDay {


    public static final int DST_RANGE_START_INDEX = 0;
    public static final int SRC_RANGE_START_INDEX = 1;
    public static final int RANGE_LENGTH_INDEX = 2;

    @Override
    public String solvePart1(String input) {
        var lines = input.lines().toList();

        List<Long> seeds = new ArrayList<>();
        List<List<Long>> seedToSoil = new ArrayList<>();
        List<List<Long>> soilToFertilizer = new ArrayList<>();
        List<List<Long>> fertilizerToWater = new ArrayList<>();
        List<List<Long>> waterToLight = new ArrayList<>();
        List<List<Long>> lightToTemperature = new ArrayList<>();
        List<List<Long>> temperatureToHumidity = new ArrayList<>();
        List<List<Long>> humidityToLocation = new ArrayList<>();

        int seedToSoilMapStartLineIdx = 0;
        int soilToFertilizerMapStartLineIdx = 0;
        int fertilizerToWaterMapStartLineIdx = 0;
        int waterToLightMapStartLineIdx = 0;
        int lightToTemperatureStartLineIdx = 0;
        int temperatureToHumidityStartLineIdx = 0;
        int humidityToLocationStartLineIdx = 0;

        // Collect the seeds
        Arrays.stream(lines.get(0).split("seeds: ")[1].split(" ")).forEach(v -> seeds.add(Long.parseLong(v)));

        // Collect the lists for everything else
        var index = 0;
        for (String line : lines) {
            switch (line) {
                case "seed-to-soil map:" -> seedToSoilMapStartLineIdx = index;
                case "soil-to-fertilizer map:" -> soilToFertilizerMapStartLineIdx = index;
                case "fertilizer-to-water map:" -> fertilizerToWaterMapStartLineIdx = index;
                case "water-to-light map:" -> waterToLightMapStartLineIdx = index;
                case "light-to-temperature map:" -> lightToTemperatureStartLineIdx = index;
                case "temperature-to-humidity map:" -> temperatureToHumidityStartLineIdx = index;
                case "humidity-to-location map:" -> humidityToLocationStartLineIdx = index;
            }
            index++;
        }

        for (int i = seedToSoilMapStartLineIdx + 1; i < soilToFertilizerMapStartLineIdx - 1; i++) {
            seedToSoil.add(getValues(lines, i));
        }

        for (int i = soilToFertilizerMapStartLineIdx + 1; i < fertilizerToWaterMapStartLineIdx - 1; i++) {
            soilToFertilizer.add(getValues(lines, i));
        }

        for (int i = fertilizerToWaterMapStartLineIdx + 1; i < waterToLightMapStartLineIdx - 1; i++) {
            fertilizerToWater.add(getValues(lines, i));
        }

        for (int i = waterToLightMapStartLineIdx + 1; i < lightToTemperatureStartLineIdx - 1; i++) {
            waterToLight.add(getValues(lines, i));
        }

        for (int i = lightToTemperatureStartLineIdx + 1; i < temperatureToHumidityStartLineIdx - 1; i++) {
            lightToTemperature.add(getValues(lines, i));
        }

        for (int i = temperatureToHumidityStartLineIdx + 1; i < humidityToLocationStartLineIdx - 1; i++) {
            temperatureToHumidity.add(getValues(lines, i));
        }

        for (int i = humidityToLocationStartLineIdx + 1; i < lines.size(); i++) {
            humidityToLocation.add(getValues(lines, i));
        }

        List<Long> soils = new ArrayList<>();
        seeds.forEach(s -> soils.add(mapValues(s, seedToSoil)));

        List<Long> fertilizers = new ArrayList<>();
        soils.forEach(s -> fertilizers.add(mapValues(s, soilToFertilizer)));

        List<Long> waters = new ArrayList<>();
        fertilizers.forEach(f -> waters.add(mapValues(f, fertilizerToWater)));

        List<Long> lights = new ArrayList<>();
        waters.forEach(w -> lights.add(mapValues(w, waterToLight)));

        List<Long> temperatures = new ArrayList<>();
        lights.forEach(l -> temperatures.add(mapValues(l, lightToTemperature)));

        List<Long> humidity = new ArrayList<>();
        temperatures.forEach(t -> humidity.add(mapValues(t, temperatureToHumidity)));

        List<Long> locations = new ArrayList<>();
        humidity.forEach(h -> locations.add(mapValues(h, humidityToLocation)));

        long result = locations.get(0);
        for (int i = 1; i < locations.size(); i++) {
            if (locations.get(i) < result) {
                result = locations.get(i);
            }
        }
        return String.valueOf(result);
    }


    @Override
    public String solvePart2(String input) {
        var lines = input.lines().toList();

        List<Long> seeds = new ArrayList<>();
        List<List<Long>> seedToSoil = new ArrayList<>();
        List<List<Long>> soilToFertilizer = new ArrayList<>();
        List<List<Long>> fertilizerToWater = new ArrayList<>();
        List<List<Long>> waterToLight = new ArrayList<>();
        List<List<Long>> lightToTemperature = new ArrayList<>();
        List<List<Long>> temperatureToHumidity = new ArrayList<>();
        List<List<Long>> humidityToLocation = new ArrayList<>();

        int seedToSoilMapStartLineIdx = 0;
        int soilToFertilizerMapStartLineIdx = 0;
        int fertilizerToWaterMapStartLineIdx = 0;
        int waterToLightMapStartLineIdx = 0;
        int lightToTemperatureStartLineIdx = 0;
        int temperatureToHumidityStartLineIdx = 0;
        int humidityToLocationStartLineIdx = 0;

        // Collect the seeds
        List<String> seedsStringValues = Arrays.stream(lines.get(0).split(": ")[1].split(" ")).toList();
        for (int i = 0; i < seedsStringValues.size(); i += 2) {
            long rangeStart = Long.parseLong(seedsStringValues.get(i));
            long rangeLength = Long.parseLong(seedsStringValues.get(i + 1));
            for (int j = 0; j < rangeLength; j++) {
                seeds.add(rangeStart + j);
            }
        }

        // Collect the lists for everything else
        var index = 0;
        for (String line : lines) {
            switch (line) {
                case "seed-to-soil map:" -> seedToSoilMapStartLineIdx = index;
                case "soil-to-fertilizer map:" -> soilToFertilizerMapStartLineIdx = index;
                case "fertilizer-to-water map:" -> fertilizerToWaterMapStartLineIdx = index;
                case "water-to-light map:" -> waterToLightMapStartLineIdx = index;
                case "light-to-temperature map:" -> lightToTemperatureStartLineIdx = index;
                case "temperature-to-humidity map:" -> temperatureToHumidityStartLineIdx = index;
                case "humidity-to-location map:" -> humidityToLocationStartLineIdx = index;
            }
            index++;
        }

        for (int i = seedToSoilMapStartLineIdx + 1; i < soilToFertilizerMapStartLineIdx - 1; i++) {
            seedToSoil.add(getValues(lines, i));
        }

        for (int i = soilToFertilizerMapStartLineIdx + 1; i < fertilizerToWaterMapStartLineIdx - 1; i++) {
            soilToFertilizer.add(getValues(lines, i));
        }

        for (int i = fertilizerToWaterMapStartLineIdx + 1; i < waterToLightMapStartLineIdx - 1; i++) {
            fertilizerToWater.add(getValues(lines, i));
        }

        for (int i = waterToLightMapStartLineIdx + 1; i < lightToTemperatureStartLineIdx - 1; i++) {
            waterToLight.add(getValues(lines, i));
        }

        for (int i = lightToTemperatureStartLineIdx + 1; i < temperatureToHumidityStartLineIdx - 1; i++) {
            lightToTemperature.add(getValues(lines, i));
        }

        for (int i = temperatureToHumidityStartLineIdx + 1; i < humidityToLocationStartLineIdx - 1; i++) {
            temperatureToHumidity.add(getValues(lines, i));
        }

        for (int i = humidityToLocationStartLineIdx + 1; i < lines.size(); i++) {
            humidityToLocation.add(getValues(lines, i));
        }

        List<Long> soils = new ArrayList<>();
        seeds.forEach(s -> soils.add(mapValues(s, seedToSoil)));

        List<Long> fertilizers = new ArrayList<>();
        soils.forEach(s -> fertilizers.add(mapValues(s, soilToFertilizer)));

        List<Long> waters = new ArrayList<>();
        fertilizers.forEach(f -> waters.add(mapValues(f, fertilizerToWater)));

        List<Long> lights = new ArrayList<>();
        waters.forEach(w -> lights.add(mapValues(w, waterToLight)));

        List<Long> temperatures = new ArrayList<>();
        lights.forEach(l -> temperatures.add(mapValues(l, lightToTemperature)));

        List<Long> humidity = new ArrayList<>();
        temperatures.forEach(t -> humidity.add(mapValues(t, temperatureToHumidity)));

        List<Long> locations = new ArrayList<>();
        humidity.forEach(h -> locations.add(mapValues(h, humidityToLocation)));

        long result = locations.get(0);
        for (int i = 1; i < locations.size(); i++) {
            if (locations.get(i) < result) {
                result = locations.get(i);
            }
        }
        return String.valueOf(result);
    }

    private static ArrayList<Long> getValues(List<String> lines, int i) {
        long[] values = Arrays.stream(lines.get(i).split(" ")).mapToLong(Long::parseLong).toArray();
        var partList = new ArrayList<Long>();
        partList.add(values[0]);
        partList.add(values[1]);
        partList.add(values[2]);
        return partList;
    }

    private static long mapValues(long source, List<List<Long>> lists) {
        for (var list : lists) {
            if (list.get(SRC_RANGE_START_INDEX) <= source && list.get(SRC_RANGE_START_INDEX) + list.get(RANGE_LENGTH_INDEX) > source) {
                long diff = source - list.get(SRC_RANGE_START_INDEX);
                return list.get(DST_RANGE_START_INDEX) + diff;
            }
        }
        return source;
    }
}
