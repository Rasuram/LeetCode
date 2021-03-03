package allexamples;

public class MarsExploration {

    // Complete the marsExploration function below.
    static int marsExploration(String s) {
        String second = "SOS";
        int changes = 0;
        while (s.length() > 0) {
            String signal = s.substring(0, 3);
            if (!signal.equals(second)) {
                for (int i = 0; i < signal.length(); i++) {
                    char c = signal.charAt(i);
                    if (second.charAt(i) != c) {
                        changes++;
                    }
                }
            }
            s = s.substring(3);
        }
        return changes;
    }


    public static void main(String[] args) {
        System.out.println(marsExploration("SSSSSSSSSSSSSSSOOOOOOOOOOOOOOOOOOOOOOOOOSSSSSSSO"));

    }
}
