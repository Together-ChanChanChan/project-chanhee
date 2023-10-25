package llocr.mp3;

import java.util.Scanner;

public class Menu {
    public void mainMenu() {
        Scanner sc = new Scanner(System.in);
        MusicPlayer mp3 = new MusicPlayer();

        do {
            System.out.println("======== mp3 player ========");
            System.out.println("0. 음악 리스트 전체 보기");
            System.out.println("1. 음악 선택 (음악을 선택하면 자동으로 재생됩니다.)");
            System.out.println("2. 음악 재생하기");
            System.out.println("3. 음악 정지하기");
            System.out.println("4. 이전 음악 재생");
            System.out.println("5. 다음 음악 재생");
            System.out.println("6. 음악 추가");
            System.out.println("7. 음악 삭제");
            System.out.println("8. 음량 낮추기");
            System.out.println("9. 음량 높이기");
            System.out.println("10. 프로그램 종료");
            System.out.println("============================");
            System.out.print("실행할 메뉴를 입력해 주세요 : ");
            int menu = sc.nextInt();

            switch (menu) {
                case 0 :
                    mp3.printAllMusics();
                    break;
                case 1 :
                    mp3.choseMusic();
                    break;
                case 2 :
                    mp3.musicPlay();
                    break;
                case 3 :
                    mp3.musicPause();
                    break;
                case 4 :
                    mp3.beforeMusic();
                    break;
                case 5 :
                    mp3.nextMusic();
                    break;
                case 6 :
                    mp3.addMusic();
                    break;
                case 7 :
                    mp3.deleteMusic();
                    break;
                case 8 :
                    mp3.volumeDown();
                    break;
                case 9 :
                    mp3.volumeUp();
                    break;
                case 10 :
                    System.out.print("프로그램을 종료하시겠습니까? (예 Y : 아니오 N) : ");
                    String check = sc.next();
                    sc.nextLine();
                    if(check.charAt(0) == 'y' || check.charAt(0) == 'Y') {
                        System.exit(0);
                    } else {
                        System.out.println("메인 메뉴로 돌아갑니다.");
                        return;
                    }
                    break;
                default: return;
            }
        }while (true);
    }
}
