package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class PointsTest {
    @Test
    void 점들이_서로_다른지_확인_테스트() {
        List<Point> pointList = Arrays.asList(
                new Point(Scalar.of(1), Scalar.of(3)),
                new Point(Scalar.of(1), Scalar.of(3))
        );
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Points(pointList);
        }).withMessage("중복된 좌표가 존재합니다");
    }

    @Test
    void 점들이_정렬_상태인지_확인() {
        List<Point> pointArrangeList = Arrays.asList(
                new Point(Scalar.of(1), Scalar.of(3)),
                new Point(Scalar.of(3), Scalar.of(5)),
                new Point(Scalar.of(5), Scalar.of(5)),
                new Point(Scalar.of(1), Scalar.of(6))
        );
        List<Point> pointNotArrangeList = Arrays.asList(
                new Point(Scalar.of(3), Scalar.of(5)),
                new Point(Scalar.of(1), Scalar.of(3)),
                new Point(Scalar.of(1), Scalar.of(6)),
                new Point(Scalar.of(5), Scalar.of(5))
        );
        assertThat(new Points(pointNotArrangeList)).isEqualTo(new Points(pointArrangeList));
    }
}
