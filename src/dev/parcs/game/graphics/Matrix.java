package dev.parcs.game.graphics;

import java.awt.*;
import java.util.Random;


public class Matrix {
    private final String alphabets = "0987654321abcdefghijklmnopqrstuvwxyz";
    public int x, y = 0;
    public char[][] chars;
    private int length;
    private Random random;
    private AlphaComposite alcom;
    private Font font;
    private float alpha;
    private int timer;
    private int fontSize;

    public Matrix(int x) {
        this.x = x;
        random = new Random();
        length = random.nextInt(32) + 1;
        chars = new char[length][1];
        y = (-1) * 9 * length;
        font = new Font("matrix code nfi", Font.PLAIN, 20);
        for (char[] aChar : chars) {
            aChar[0] = alphabets.charAt(random.nextInt(alphabets.length()));
        }

    }

    public void renders(Graphics2D g2D) {
        g2D.setFont(font);
        fontSize = g2D.getFont().getSize();

        int i = 0, temp = 0;
        while (i < chars.length) {

            timer++;
            alpha = temp * 0.1f;
            if (timer > 50) {
                chars[i][0] = alphabets.charAt(random.nextInt(alphabets.length()));
                y += random.nextInt(7 - 3) + 3;
                timer = 0;
            }
            if (chars.length - 1 == i || chars.length - 2 == i || chars.length - 3 == i) {
                g2D.setColor(Color.lightGray);
            } else {
                g2D.setColor(Color.GREEN);
            }
            if (alpha == 1.0f) {

                temp = 0;
            }
            alcom = AlphaComposite.getInstance(
                    AlphaComposite.SRC_OVER, alpha);
            g2D.setComposite(alcom);
            g2D.drawChars(chars[i], 0, 1, x, y + (i * fontSize - 2));

            i++;
            temp++;
        }

    }


}

