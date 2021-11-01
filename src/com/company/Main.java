package com.company;

import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {
        Album album = new Album("Spring","Daniel");
        album.addSong("Heart",4.3);
        album.addSong("Mother",4.5);
        album.addSong("I put the finger on you",4.5);
        album.addSong("Believe",4.5);
        album.addSong("Never be alone",4.5);
        album.addSong("Impossible work",4.1);
        album.addSong("Never walk alone",2.1);
        album.addSong("Dream",3.2);
        album.addSong("Broken heart",4.1);
        album.addSong("Love love",1.7);
        album.addSong("Wold on",1.9);
        albums.add(album);

        album = new Album("Winter","Celine Dian");
        album.addSong("The power of love",5.1);
        album.addSong("I drove all night",2.2);
        album.addSong("All by Myself",6.3);
        album.addSong("Let's talk about love",3.3);
        album.addSong("Falling into you",4.2);
        album.addSong("A decade of song",6.2);
        albums.add(album);

        LinkedList<Song> playList = new LinkedList<Song>();
        albums.get(0).addToPlayList("You can't do it right",playList);
        albums.get(0).addToPlayList("Fire man",playList);
        albums.get(0).addToPlayList("Never work alone",playList);
        albums.get(0).addToPlayList("Heart",playList);
        albums.get(1).addToPlayList(1,playList);
        albums.get(1).addToPlayList(5,playList);
        albums.get(1).addToPlayList(2,playList);
        albums.get(1).addToPlayList(3,playList);
        albums.get(1).addToPlayList(23,playList);

        play(playList);

    }
    private static void play(LinkedList<Song> playList){
        ListIterator<Song> listIterator = playList.listIterator();
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        if(playList.size()==0){
            System.out.println("No songs in playlist");
            return;
        }else {
            System.out.println("Now playing " + listIterator.next().toString());
        }

        while(!quit){
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action){
                case 0:
                    System.out.println("Playing complete.");
                    quit = true;
                    break;
                case 1:
                    if(!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now playing "+listIterator.next().toString());
                    }else {
                        System.out.println("We have reached the end of the playlist");
                        forward = false;
                    }
                    break;
                case 2:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now visiting "+listIterator.previous());
                    }else {
                        System.out.println("We are at the start of the list");
                        forward = true;
                    }
                    break;
                case 3:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("New replaying " + listIterator.previous().toString());
                            forward = false;
                        }else {
                            System.out.println("We are at the start of the list");
                        }
                    }else {
                        if (listIterator.hasNext()) {
                            System.out.println("Now replaying " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("We have reached the end of the list");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if(playList.size()>0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("Now playing next Song"+listIterator.next());
                        }else if(listIterator.hasPrevious()){
                            System.out.println("Now playing previous song "+listIterator.previous());
                        }
                    }
                    break;
            }
        }
    }
    public static void printMenu(){
        System.out.println("Available actions:\npress");
        System.out.println("0 to quit\n"+
                "1 - to play next song\n"+
                "2 - to play previous song\n"+
                "3 - to replace the current song\n"+
                "4 - list songs in the playlist\n"+
                "5 - print available actions.");
    }
    public static void printList(LinkedList<Song> playList){
        Iterator<Song> iterator = playList.iterator();
        System.out.println("=============================");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("=============================");
    }
}
