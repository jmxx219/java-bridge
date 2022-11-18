package bridge.view;

import bridge.domain.Command;
import bridge.domain.GameStatus;
import bridge.domain.Movement;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String GAME_START = "다리 건너기 게임을 시작합니다.";
    private static final String GAME_OVER = "최종 게임 결과";

    private static final String INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String INPUT_PLAYER_MOVE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String INPUT_PLAYER_COMMAND =
            "게임을 다시 시도할지 여부를 입력해주세요. (재시도: " + Command.RETRY.getCode() + ", 종료: " + Command.QUIT.getCode() + ")";

    private static final String BRIDGE_START = "[ ";
    private static final String BRIDGE_END = " ]";

    private static final String GAME_SUCCESS_OR_NOT = "게임 성공 여부: ";
    private static final String TOTAL_NUMBER_OF_ATTEMPTS = "총 시도한 횟수: ";

    private void print(String printString) {
        System.out.println(printString);
    }

    public void printNewline() {
        print("");
    }

    public void printGameStart() {
        print(GAME_START);
        printNewline();
    }

    public void printGameOver() {
        print(GAME_OVER);
    }

    public void inputBridgeSize() {
        print(INPUT_BRIDGE_SIZE);
    }

    public void inputPlayerMove() {
        print(INPUT_PLAYER_MOVE);
    }

    public void inputPlayerCommand() {
        print(INPUT_PLAYER_COMMAND);
    }

    public void printMap(Map<Movement, List<String>> crossingResults) {
        for (Movement movement : Movement.values()) {
            print(toStingFormatMovement(crossingResults.get(movement)));
        }
        printNewline();
    }

    private String toStingFormatMovement(List<String> resultStatus) {
        return BRIDGE_START + resultStatus.stream().collect(Collectors.joining(" | ")) + BRIDGE_END;
    }

    public void printResult(GameStatus gameStatus, int numberOfAttempts) {
        print(GAME_SUCCESS_OR_NOT + gameStatus.getStatus());
        print(TOTAL_NUMBER_OF_ATTEMPTS + numberOfAttempts);
    }
}
