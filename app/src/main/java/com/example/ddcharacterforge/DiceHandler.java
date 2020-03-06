package com.example.ddcharacterforge;

public class DiceHandler<d12, d20, d10, d8, d6, d4> extends DiceActivity {

//Rolling d20
    int d20 = (int) (Math.random() * ( 20 - 1 ));
//Rolling d12
    int d12 = (int) (Math.random() * ( 12 - 1 ));
//Rolling d10
    int d10 = (int) (Math.random() * ( 10 - 1 ));
//Rolling d8
    int d8 = (int) (Math.random() * ( 8 - 1 ));
//Rolling d6
    int d6 = (int) (Math.random() * ( 6 - 1 ));
//Rolling d4
    int d4 = (int) (Math.random() * ( 4 - 1 ));

    //System.out.println(d20);
    //System.out.println(d12);
    //System.out.println(d10);
    //System.out.println(d8);
    //System.out.println(d6);
    //System.out.println(d4);
}
