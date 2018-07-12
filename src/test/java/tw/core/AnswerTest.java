package tw.core;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tw.core.model.Record;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

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

}