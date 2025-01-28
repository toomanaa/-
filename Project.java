import java.util.Scanner; // استيراد مكتبة Scanner لقراءة إدخال المستخدم
import java.util.Random; // استيراد مكتبة Random لتوليد أرقام عشوائية

public class WordScrambleGame {
    public static void main(String[] args) {
        // مصفوفة تحتوي على الكلمات التي سيتم استخدامها في اللعبة
        String[] words = {"apple", "banana", "orange", "grape", "mango", "cherry", "peach", "melon"};
        
        // تعريف المتغيرات الأساسية للعبة
        int score = 0; // لتخزين نقاط اللاعب
        int totalRounds = 5; // عدد الجولات التي ستلعبها اللعبة
        Random random = new Random(); // كائن Random لاختيار الكلمات عشوائيًا
        Scanner scanner = new Scanner(System.in); // كائن Scanner لقراءة الإدخال من المستخدم
        
        // طباعة رسالة ترحيبية
        System.out.println("Welcome to the Word Scramble Game!");
        System.out.println("Unscramble the letters to form the correct word.");
        System.out.println("Type 'exit' to quit the game anytime.\n");
        
        // الحلقة الرئيسية للعبة
        for (int round = 1; round <= totalRounds; round++) {
            // اختيار كلمة عشوائية من المصفوفة
            String originalWord = words[random.nextInt(words.length)];
            
            // خلط الكلمة المختارة عشوائيًا
            String scrambledWord = scrambleWord(originalWord, random);
            
            // عرض الجولة والكلمة المخلوطة للمستخدم
            System.out.println("Round " + round + ":");
            System.out.println("Scrambled Word: " + scrambledWord);
            
            // طلب تخمين المستخدم
            System.out.print("Your guess: ");
            String guess = scanner.nextLine().trim().toLowerCase(); // قراءة الإدخال
            
            // التحقق مما إذا كان المستخدم يريد الخروج من اللعبة
            if (guess.equals("exit")) {
                System.out.println("Thanks for playing! Your final score is: " + score);
                break;
            }
            
            // التحقق من صحة التخمين
            if (guess.equals(originalWord)) {
                System.out.println("Correct! +10 points.");
                score += 10; // إضافة النقاط إذا كانت الإجابة صحيحة
            } else {
                System.out.println("Incorrect! The correct word was: " + originalWord);
            }
            
            // عرض النقاط الحالية
            System.out.println("Your current score: " + score + "\n");
        }
        
        // عرض رسالة نهاية اللعبة
        System.out.println("Game Over! Your final score is: " + score);
        scanner.close(); // إغلاق Scanner
    }

    // دالة لخلط حروف الكلمة
    private static String scrambleWord(String word, Random random) {
        char[] letters = word.toCharArray(); // تحويل الكلمة إلى مصفوفة من الحروف
        for (int i = 0; i < letters.length; i++) {
            // اختيار مواضع عشوائية لتبديل الحروف
            int j = random.nextInt(letters.length);
            
            // تبديل الحروف
            char temp = letters[i];
            letters[i] = letters[j];
            letters[j] = temp;
        }
        return new String(letters); // تحويل مصفوفة الحروف إلى نص وإعادتها
    }
}
