public class OddEvenChecker implements OddEvenCheckerInterface {
    @Override
    public boolean isEven(int number) {
        return number % 2 == 0;
    }

    @Override
    public boolean isOdd(int number) {
        return number % 2 != 0;
    }
}
