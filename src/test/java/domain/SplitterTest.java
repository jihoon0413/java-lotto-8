package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SplitterTest {

    Splitter splitter = new Splitter();

    @Test
    public void givenStringWhenSplitThenStringArray() {
        String str = "1,2,3,4,5,6";
        String[] result = splitter.split(str);

        assertThat(result.length).isEqualTo(6);
    }

}