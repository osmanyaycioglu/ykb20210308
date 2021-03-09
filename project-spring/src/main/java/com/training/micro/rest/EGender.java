package com.training.micro.rest;

public enum EGender {

    MALE(1, "Erkek") {

        @Override
        public String shortDesc() {
            return this.desc + " " + this.i;
        }
    },
    FEMALE(2, "Kadın");

    final int    i;
    final String desc;

    EGender(final int iParam,
            final String descParam) {
        this.i = iParam;
        this.desc = descParam;
    }

    public int getI() {
        return this.i;
    }

    public String getDesc() {
        return this.desc;
    }

    public String shortDesc() {
        return this.i + " " + this.desc;
    }

    public static void main(final String[] args) {

        System.out.println(EGender.MALE.shortDesc());
        System.out.println(EGender.FEMALE.shortDesc());


    }

}
