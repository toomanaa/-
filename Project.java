import java.util.Scanner; // استيراد المكتبة المسؤولة عن أخذ الإدخال من المستخدم
import java.util.Random; // استيراد المكتبة المسؤولة عن إنشاء أرقام عشوائية

public class WordScrambleGame {
    public static void main(String[] args) {
        // تعريف مصفوفة تحتوي على مجموعة من الكلمات
        String[] words = {"apple", "banana", "orange", "grape", "mango", "cherry", "peach", "melon"};
        
        // تعريف المتغيرات الأساسية للعبة
        int score = 0; // تخزين النقاط
        int totalRounds = 5; // عدد الجولات في اللعبة
        Random random = new Random(); // كائن لإنشاء أرقام عشوائية
        Scanner scanner = new Scanner(System.in); // كائن لقراءة الإدخال من المستخدم
        
        // رسالة ترحيبية بالمستخدم
        System.out.println("مرحبًا بك في لعبة ترتيب الحروف!");
        System.out.println("قم بإعادة ترتيب الحروف لتكوين الكلمة الصحيحة.");
        System.out.println("اكتب 'exit' لإنهاء اللعبة في أي وقت.\n");
        
        // الحلقة الرئيسية للعبة
        for (int round = 1; round <= totalRounds; round++) {
            // اختيار كلمة عشوائيًا من المصفوفة
            String originalWord = words[random.nextInt(words.length)];
            
            // خلط حروف الكلمة
            String scrambledWord = scrambleWord(originalWord, random);
            
            // عرض الجولة والكلمة المخلوطة للمستخدم
            System.out.println("الجولة " + round + ":");
            System.out.println("الكلمة المخلوطة: " + scrambledWord);
            
            // طلب التخمين من المستخدم
            System.out.print("تخمينك: ");
            String guess = scanner.nextLine().trim().toLowerCase(); // قراءة الإدخال
            
            // إنهاء اللعبة إذا كتب المستخدم "exit"
            if (guess.equals("exit")) {
                System.out.println("شكرًا للعب! مجموع نقاطك النهائي: " + score);
                break;
            }
            
            // التحقق من صحة التخمين
            if (guess.equals(originalWord)) {
                System.out.println("إجابة صحيحة! +10 نقاط.");
                score += 10; // إضافة النقاط
            } else {
                System.out.println("إجابة خاطئة! الكلمة الصحيحة كانت: " + originalWord);
            }
            
            // عرض النقاط الحالية
            System.out.println("مجموع النقاط الحالي: " + score + "\n");
        }
        
        // رسالة نهاية اللعبة
        System.out.println("انتهت اللعبة! مجموع نقاطك النهائي هو: " + score);
        scanner.close(); // إغلاق كائن الإدخال
    }

    // دالة لخلط حروف الكلمة
    private static String scrambleWord(String word, Random random) {
        char[] letters = word.toCharArray(); // تحويل الكلمة إلى مصفوفة حروف
        for (int i = 0; i < letters.length; i++) {
            // اختيار موقع عشوائي لتبديل الحروف
            int j = random.nextInt(letters.length);
            
            // تبديل الحروف
            char temp = letters[i];
            letters[i] = letters[j];
            letters[j] = temp;
        }
        return new String(letters); // تحويل المصفوفة إلى نص وإرجاعه
    }
}
