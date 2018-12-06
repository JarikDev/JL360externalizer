package com;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        House house=new House();
        house.rooms=5;
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(new File("temp.txt")));
        house.writeExternal(oos);
        oos.close();

        ObjectInputStream ois= new ObjectInputStream(new FileInputStream(new File("temp.txt")));
        House house1=new House();
        house1.readExternal(ois);
        System.out.println(house1.rooms);
    }
    static class House implements Externalizable {int rooms;

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeInt(rooms);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
    rooms=in.readInt();
        }
    }
}
