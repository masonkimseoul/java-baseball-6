package baseball.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.Test;

public class InputViewTest {

    void userInput(String input) {
        InputStream is = new ByteArrayInputStream(input.getBytes());
        System.setIn(is);
    }

    @Test
    void 숫자_입력_변환_테스트() {
        userInput("234");
        int userNumbers = InputView.getUserNumbers();
        assertThat(userNumbers).isEqualTo(234);
    }

    @Test
    void 문자_포함_예외_테스트() {
        userInput("a34");

        Exception e = assertThrows(IllegalArgumentException.class, InputView::getUserNumbers);
        assertThat(e.getClass()).isEqualTo((IllegalArgumentException.class));
        assertThat(e.getMessage()).isEqualTo("숫자를 입력해주세요.");
    }

    @Test
    void 입력_길이_미만_예외_테스트() {
        userInput("12");

        Exception e = assertThrows(IllegalAccessException.class, InputView::getUserNumbers);
        assertThat(e.getClass()).isEqualTo(IllegalArgumentException.class);
        assertThat(e.getMessage()).isEqualTo("3자리의 수를 입력해주세요.");
    }

    @Test
    void 입력_길이_초과_예외_테스트() {
        userInput("1234");

        Exception e = assertThrows(IllegalAccessException.class, InputView::getUserNumbers);
        assertThat(e.getClass()).isEqualTo(IllegalArgumentException.class);
        assertThat(e.getMessage()).isEqualTo("3자리의 수를 입력해주세요.");
    }

    @Test
    void 입력_숫자_중복_예외_테스트() {
        userInput("223");

        Exception e = assertThrows(IllegalAccessException.class, InputView::getUserNumbers);
        assertThat(e.getClass()).isEqualTo(IllegalArgumentException.class);
        assertThat(e.getMessage()).isEqualTo("서로 다른 3자리의 수를 입력해주세요.");
    }

    @Test
    void 입력_0값_예외_테스트() {
        userInput("012");

        Exception e = assertThrows(IllegalAccessException.class, InputView::getUserNumbers);
        assertThat(e.getClass()).isEqualTo(IllegalArgumentException.class);
        assertThat(e.getMessage()).isEqualTo("0이 포함되지 않는 수를 입력해주세요.");
    }

    @Test
    void 게임_종료_입력_예외_테스트() {
        userInput("0");

        Exception e = assertThrows(IllegalAccessException.class, InputView::getUserNumbers);
        assertThat(e.getClass()).isEqualTo(IllegalArgumentException.class);
        assertThat(e.getMessage()).isEqualTo("1, 2 중 하나를 입력해주세요.");
    }
}
