package tw.core;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tw.core.exception.AnswerFormatIncorrectException;
import tw.core.model.Record;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Created by jxzhong on 2017/9/23.
 */
public class AnswerTest {
    private Answer actualAnswer;

    @BeforeEach
    public void setUp() {
        actualAnswer = Answer.createAnswer("1 2 3 4");
    }
    @Test
    public void should_get_the_Record_when_call_check_input_inputAnswer_1234() throws Exception {
        //given
        Answer inputAnswer = Answer.createAnswer("1 2 3 4");
        //when
        Record record = actualAnswer.check(inputAnswer);
        //then
        assertThat(record.getValue(),is("4A0B"));

    }
    @Test
    public void should_get_the_Record_when_call_check_input_inputAnswer_1435() throws Exception {
        //given
        Answer inputAnswer = Answer.createAnswer("1 4 3 5");
        //when
        Record record = actualAnswer.check(inputAnswer);
        //then
        assertThat(record.getValue(),is("2A1B"));

    }
    @Test
    public void should_get_the_Record_when_call_validate_input_inputAnswer_1233() throws Exception {
        //given
        Answer inputAnswer = new Answer();
        List<String> numList = Arrays.asList("1","2","3","3");
        inputAnswer.setNumList(numList);
        //when
        try {
            inputAnswer.validate();
        }catch (AnswerFormatIncorrectException e){
            fail("Answer format is incorrect");
        }


    }
    @Test
    public void should_get_the_Record_when_call_validate_input_inputAnswer_1_2_10_11() throws Exception {
        //given
        Answer inputAnswer = new Answer();
        List<String> numList = Arrays.asList("1","2","10","11");
        inputAnswer.setNumList(numList);
        //when
        try {
            inputAnswer.validate();
        }catch (AnswerFormatIncorrectException e){
            fail("Answer format is incorrect");
        }


    }
    @Test
    public void should_get_the_Record_when_call_validate_input_inputAnswer_1_2_3_4() throws Exception {
        //given
        Answer inputAnswer = new Answer();
        List<String> numList = Arrays.asList("1","2","3","4");
        inputAnswer.setNumList(numList);
        //when
        try {
            inputAnswer.validate();
        }catch (AnswerFormatIncorrectException e){
            fail("Answer format is incorrect");
        }
    }

    @Test
    public void should_get_the_Record_when_call_getIndexOfNum_input_inputAnswer_1234() throws Exception {
        //given
        Answer inputAnswer = new Answer();
        List<String> numList = Arrays.asList("1","2","3","4");
        inputAnswer.setNumList(numList);
        //when
        int index = inputAnswer.getIndexOfNum("1");
        //then
        assertThat(index,is(0));

    }
    @Test
    public void should_get_1_2_3_4_when_call_toString_input_inputAnswer_1_2_3_4() throws Exception {
        //given
        Answer inputAnswer = new Answer();
        List<String> numList = Arrays.asList("1","2","3","4");
        inputAnswer.setNumList(numList);
        //when

        String result = inputAnswer.toString();

        assertThat(result,is("1 2 3 4"));

    }
}