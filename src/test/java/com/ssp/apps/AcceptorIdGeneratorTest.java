package com.ssp.apps;

import com.ssp.apps.AcceptorIdGenerator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(Parameterized.class)
public class AcceptorIdGeneratorTest {
    private AcceptorIdGenerator acceptorIdGenerator;
    private String initialAcceptorId;
    private String nextAcceptorId;

    public AcceptorIdGeneratorTest(String initialAcceptorId, String nextAcceptorId) {
        this.initialAcceptorId = initialAcceptorId;
        this.nextAcceptorId = nextAcceptorId;
    }

    @Before
    public void setup() {
        acceptorIdGenerator = new AcceptorIdGenerator();
    }

    @Parameterized.Parameters
    public static Collection setupTestData() {
        return Arrays.asList(new Object[][]{
                {"0", "000001"},
                {"9", "00000A"},
                {"A", "00000B"},
                {"K", "00000L"},
                {"Z", "000010"},
                {"12", "000013"},
                {"1A", "00001B"},
                {"A1", "0000A2"},
                {"AL", "0000AM"},
        });
    }

    @Test
    public void should_generate_nextExxptorId() {
        String nextId = acceptorIdGenerator.nextStringIdentifier(initialAcceptorId);
        assertThat(nextId, is(equalTo(nextAcceptorId)));
    }
}
