package hw_04_02;
/*Напишите шуточную программу «Дешифратор»,
которая бы в текстовом файле могла бы заменить все предлоги на слово «Java».
 */

import java.util.Arrays;

class Decoder {
    String sentence;
    String pretext = "Без В Вместо Вне Для До Из За К На Над О От Перед По Под При Про С Сквозь Среди У Через";
    String word = "Java";

    public Decoder() {
    }

    public Decoder(String sentence) {
        this.sentence = sentence;
    }

    public String getPretext() {
        return pretext;
    }

    public void setPretext(String pretext) {
        this.pretext = pretext;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return "Текст: " + sentence + '\n' + "предлоги: " + pretext + '\n' + "слово: " + word;
    }

    public void decoder(String sentence) {

        String[] text = sentence.split(" ");
        System.out.println("Текст: ");
        for (String temp : text) {
            System.out.print(temp + " ");
        }
        System.out.println("\n=========================");

        System.out.println("Слово: " + word);
        String[] textNew = pretext.split(" ");
        System.out.print("Предлоги: ");
        for (String excuse : textNew) {
            System.out.print(excuse + " ");
        }

        System.out.println("\n=========================");

        for (int i = 0; i < text.length; i++) {
            String passage = text[i];

            for (int j = 0; j < textNew.length; j++) {
                String words = textNew[j];

                if (passage.equalsIgnoreCase(words)) {
                    passage = word;
                    break;
                }
            }
            for (String modified : Arrays.asList(passage)) {
                System.out.print(modified + " ");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {

        String str =" У дороги кот сидит.\n " +
                "За дорогой дом стоит.\n " +
                "До дороги добегу,\n " +
                "Под дорогой перейду —\n " +
                "Там подземный переход.\n " +
                "От дороги пёс идет.\n " +
                "На дороге – постовой,\n " +
                "Над дорогой – облака.\n " +
                "Шли к дороге мы с тобой\n " +
                "Два часа издалека...\n " +
                "Нам в рассказе о дороге\n " +
                "Очень помогли… (предлоги).";

        Decoder myDecoder = new Decoder();
        myDecoder.decoder(str);
    }
}