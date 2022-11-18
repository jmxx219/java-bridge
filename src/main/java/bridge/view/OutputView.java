package bridge.view;

import bridge.domain.Movement;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String NEWLINE = "\n";

    private static final String GAME_START = "다리 건너기 게임을 시작합니다.";
    private static final String INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String INPUT_PLAYER_MOVE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";

    private static final String BRIDGE_START = "[ ";
    private static final String BRIDGE_END = " ]";

    private void print(String printString) {
        System.out.println(printString);
    }

    public void gameStart() {
        print(GAME_START);
    }

    public void inputBridgeSize() {
        print(NEWLINE + INPUT_BRIDGE_SIZE);
    }

    public void inputPlayerMove() {
        print(NEWLINE + INPUT_PLAYER_MOVE);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Map<Movement, List<String>> crossingResults) {
        for(Movement movement : Movement.values()) {
            print(toStingFormatMovement(crossingResults.get(movement)));
        }
    }

    public String toStingFormatMovement(List<String> resultStatus) {
        return BRIDGE_START + resultStatus.stream().collect(Collectors.joining(" | ")) + BRIDGE_END;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
