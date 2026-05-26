package com.bajaj.bfhl.service.impl;

import com.bajaj.bfhl.dto.RequestDto;
import com.bajaj.bfhl.dto.ResponseDto;
import com.bajaj.bfhl.service.BfhlService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BfhlServiceImpl implements BfhlService {

    @Override
    public ResponseDto processData(RequestDto requestDto) {

        ResponseDto response = new ResponseDto();

        List<String> oddNumbers = new ArrayList<>();
        List<String> evenNumbers = new ArrayList<>();
        List<String> alphabets = new ArrayList<>();
        List<String> specialCharacters = new ArrayList<>();

        int sum = 0;

        StringBuilder alphabetConcat = new StringBuilder();

        for (String item : requestDto.getData()) {

            if (item.matches("\\d+")) {

                int number = Integer.parseInt(item);

                sum += number;

                if (number % 2 == 0) {
                    evenNumbers.add(item);
                } else {
                    oddNumbers.add(item);
                }

            } else if (item.matches("[a-zA-Z]+")) {

                alphabets.add(item.toUpperCase());

                alphabetConcat.append(item);

            } else {

                specialCharacters.add(item);

            }
        }

        String concatString = createAlternatingCaps(
                alphabetConcat.reverse().toString()
        );

        response.setIs_success(true);

        response.setUser_id("vaidik_laad_23092005");

        response.setEmail("vaidiklaad230756@acropolis.in");

        response.setRoll_number("0827CI231144");

        response.setOdd_numbers(oddNumbers);

        response.setEven_numbers(evenNumbers);

        response.setAlphabets(alphabets);

        response.setSpecial_characters(specialCharacters);

        response.setSum(String.valueOf(sum));

        response.setConcat_string(concatString);

        return response;
    }

    private String createAlternatingCaps(String input) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {

            if (i % 2 == 0) {
                result.append(
                        Character.toUpperCase(input.charAt(i))
                );
            } else {
                result.append(
                        Character.toLowerCase(input.charAt(i))
                );
            }
        }

        return result.toString();
    }
}