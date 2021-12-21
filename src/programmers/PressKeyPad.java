package programmers;

public class PressKeyPad {
    public String solution(int[] numbers, String hand) {
        // 1(0, 0)    2(0, 1)     3(0, 2)
        // 4(1, 0)    5(1, 1)     6(1, 2)
        // 7(2, 0)    8(2, 1)     9(2, 2)
        // 10(3, 0)   11(3, 1)    12(3, 2)
        StringBuilder answer = new StringBuilder();
        int leftIndex = 10;
        int rightIndex = 12;
        for(int number: numbers) {
            if(number == 1 || number == 4 || number == 7) {  // left scope
                answer.append("L");
                leftIndex = number;
            }else if(number == 3 || number == 6 || number == 9) {  // right scope
                answer.append("R");
                rightIndex = number;
            }else{  // center scope
                int leftDistance = getDistance(leftIndex, number);
                int rightDistance = getDistance(rightIndex, number);
                if(leftDistance < rightDistance) {
                    answer.append("L");
                    leftIndex = number;
                }else if(leftDistance > rightDistance) {
                    answer.append("R");
                    rightIndex = number;
                }else {
                    if(hand.equals("left")) {
                        answer.append("L");
                        leftIndex = number;
                    }else {
                        answer.append("R");
                        rightIndex = number;
                    }
                }
            }
        }

        return answer.toString();
    }

    public static int getDistance(int currentIndex, int number) {
        number = (number == 0) ? 11 : number;
        currentIndex = (currentIndex == 0) ? 11 : currentIndex;

        int currentY = (currentIndex - 1) / 3;
        int currentX = (currentIndex - 1) % 3;
        int numberY = number / 3;
        int numberX = 1;

        return Math.abs(currentY - numberY) + Math.abs(currentX - numberX);
    }
}
