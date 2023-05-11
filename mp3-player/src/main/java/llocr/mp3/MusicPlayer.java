package llocr.mp3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MusicPlayer {
    Scanner sc = new Scanner(System.in);
    private int volume = 0;
    private boolean isPlay;
    private String nowMusic;
    private String nowSinger;
    private int nowIndex;
    private List<Music> musicList;

    public MusicPlayer() {
        this.musicList = new ArrayList<>();
    }

    public void printAllMusics() {
        System.out.println("==== 음악 리스트 보기 ====");
        for (int i = 0; i < musicList.size(); i++) {
            System.out.println((i + 1) + ". " + musicList.get(i).getTitle() + " - " + musicList.get(i).getSinger());
        }
    }

    public void choseMusic() {
        System.out.println("==== 음악 선택하기 ====");
        System.out.print("제목을 입력해 주세요 : ");
        String title = sc.nextLine();
        System.out.print("가수를 입력해 주세요 : ");
        String singer = sc.nextLine();

        for (int i = 0; i < musicList.size(); i++) {
            Music music = musicList.get(i);
            if (music.getTitle().equals(title) && music.getSinger().equals(singer)) {
                nowMusic = title;
                nowSinger = singer;
                nowIndex = i;
                System.out.println("해당 음악이 선택되었습니다.");
                System.out.println("음악이 재생됩니다. 🎶");
                isPlay = true;
            }
        }
    }

    public void musicPlay() {
        if(isPlay) {
            System.out.println("이미 노래가 재생되고 있습니다.");
            System.out.println("현재 재생되고 있는 노래는 '" + nowSinger + "'의 '" + nowMusic +"'입니다.");
        } else if(nowMusic == null || nowSinger == null) {
            System.out.println("노래가 선택되어야 음악을 재생할 수 있습니다.");
        } else {
            System.out.println("노래를 재생합니다.");
            isPlay = true;
            System.out.println("현재 재생되고 있는 노래는 '" + nowSinger + "'의 '" + nowMusic +"'입니다.");
        }
    }

    public void musicPause() {
        if(isPlay) {
            System.out.println("노래 재생을 멈춥니다.");
            isPlay = false;
        } else {
            System.out.println("이미 노래 재생이 멈춰 있습니다.");
        }
    }

    public void beforeMusic() {
        System.out.println("==== 이전 노래 재생하기 ====");
        Music music = musicList.get((nowIndex + musicList.size() - 1) % musicList.size());
        nowMusic = music.getTitle();
        nowSinger = music.getSinger();

        System.out.println("현재 재생되고 있는 노래는 '" + nowSinger + "'의 '" + nowMusic +"'입니다.");
    }

    public void nextMusic() {
        System.out.println("==== 다음 노래 재생하기 ====");
        Music music = musicList.get((nowIndex + musicList.size() + 1) % musicList.size());
        nowMusic = music.getTitle();
        nowSinger = music.getSinger();

        System.out.println("현재 재생되고 있는 노래는 '" + nowSinger + "'의 '" + nowMusic +"'입니다.");
    }

    public void addMusic() {
        System.out.println("==== 음악 추가하기 ====");
        System.out.print("제목을 입력해 주세요 : ");
        String title = sc.nextLine();
        System.out.print("가수를 입력해 주세요 : ");
        String singer = sc.nextLine();

        Music music = new Music(title, singer);
        this.musicList.add(music);
        System.out.println("해당 음악이 추가되었습니다.");
    }

    public void deleteMusic() {
        System.out.println("==== 음악 삭제하기 ====");
        System.out.print("제목을 입력해 주세요 : ");
        String title = sc.nextLine();
        System.out.print("가수를 입력해 주세요 : ");
        String singer = sc.nextLine();

        for (int i = 0; i < musicList.size(); i++) {
            Music music = musicList.get(i);
            if (music.getTitle().equals(title) && music.getSinger().equals(singer)) {
                System.out.println("해당 음악이 삭제되었습니다.");
                musicList.remove(i);
                break;
            }
        }
    }

    public void volumeDown() {
        if(volume <= 0) {
            System.out.println("볼륨을 더 낮출 수 없습니다.");
        } else if (volume > 0) {
            volume -= 5;
            System.out.println("볼륨을 5 낮췄습니다.");
        }
        System.out.println("현재 볼륨 : " + volume);
    }

    public void volumeUp() {
        if(volume >= 100) {
            System.out.println("볼륨을 더 높일 수 없습니다.");
        } else if (volume < 100) {
            volume += 5;
            System.out.println("볼륨을 5 높였습니다.");
        }
        System.out.println("현재 볼륨 : " + volume);
    }

}
