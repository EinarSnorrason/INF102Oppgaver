package alg.searching;


import alg.symbolTables.MyHashMap;

import java.util.*;

/**
 * Bob needs to escape the fire and get to the exit!
 */
public class EscapeTheFire {
    static String room =
            "#e########\n" +
            "#        #\n" +
            "#  # #   #\n" +
            "#  #b#   #\n" +
            "#        #\n" +
            "#   f    #\n" +
            "##########";
    static int w = 10;
    static int h = 7;
    public static void main(String[] args){
        char[][] roomMap = new char[h][w];
        int[][] fireMap = new int[h][w];
        Scanner in = new Scanner(room);

        for(int i=0;in.hasNextLine();i++){
            roomMap[i] = in.nextLine().toCharArray();
        }
        for (int y=0;y<h;y++){
            for (int x=0;x<w;x++){
                fireMap[y][x]=Integer.MAX_VALUE;
            }
        }
        int[][] searchMap = fireMap.clone();

        //iterate over fires
        for (int y=0;y<h;y++){
            for (int x=0;x<h;x++){
                if (roomMap[y][x]=='f'){
                    burn(new Pos(x,y),roomMap,fireMap);
                }
            }
        }
        int timeTo=-1;
        for (int y=0;y<h;y++){
            for (int x=0;x<h;x++){
                if (roomMap[y][x]=='b'){
                    timeTo = search(new Pos(x,y),roomMap,fireMap,searchMap);
                }
            }
        }
        if (timeTo==-1) System.out.println("Impossible");
        else System.out.println(timeTo+" turns.");

        //printMap(searchMap);
    }
    private static void burn(Pos p,char[][] roomMap, int[][] fireMap){
        LinkedList<Pos> list = new LinkedList<>();
        fireMap[p.y][p.x]=0;
        //int t = 0;
        MyHashMap<Pos,Pos> from = new MyHashMap<>();
        addNeighbs(p,from,list);
        while(!list.isEmpty()){
            Pos n = list.poll();
            Pos prev = from.get(n);
            int prevTime=fireMap[prev.y][prev.x];
            try{
                if (roomMap[n.y][n.x]!='#'&& fireMap[n.y][n.x]>prevTime){
                    fireMap[n.y][n.x]=prevTime+1;
                    addNeighbs(n,from,list);
                }

            } catch (Exception e){
                System.out.println(n.y+","+n.x);
                System.exit(0);
            }
        }
    }

    private static int search(Pos p,char[][] roomMap, int[][] fireMap, int[][] searchMap){
        LinkedList<Pos> list = new LinkedList<>();

        searchMap[p.y][p.x]=0;
        MyHashMap<Pos,Pos> from = new MyHashMap<>();
        addNeighbs(p,from,list);
        while(!list.isEmpty()){
            Pos n = list.poll();
            Pos prev = from.get(n);
            int prevTime=searchMap[prev.y][prev.x];
            if (roomMap[n.y][n.x]=='e') return prevTime+1;
            if (roomMap[n.y][n.x]!='#'&& prevTime+1<fireMap[n.y][n.x]){
                searchMap[n.y][n.x]=prevTime+1;
                addNeighbs(n,from,list);
            }
        }
        return -1;
    }


    private static void addNeighbs(Pos p,MyHashMap<Pos,Pos> from,LinkedList<Pos> list){
        ArrayList<Pos> n = new ArrayList<>();
        n.add(new Pos(p.x-1,p.y));
        n.add(new Pos(p.x+1,p.y));
        n.add(new Pos(p.x,p.y-1));
        n.add(new Pos(p.x,p.y+1));

        for(Pos i:n){
            if (!from.contains(i)&&i.x>=0&&i.y>=0&&i.x<w&&i.y<h){
                list.add(i);
                from.put(i,p);
            }
        }
    }

    private static void printMap(int[][] map){
        for (int y=0;y<map.length;y++){
            for (int x=0;x<map[0].length;x++){
                if (map[y][x]==Integer.MAX_VALUE) map[y][x]=9;
                System.out.print(map[y][x]+",");
            }
            System.out.println();
        }
    }
    private static void printMap(char[][] map){
        for (int y=0;y<map.length;y++){
            for (int x=0;x<map[0].length;x++){
                System.out.print(map[y][x]);
            }
            System.out.println();
        }
    }
}
