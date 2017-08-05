package hotdog.commons;

public class Base {

	private static int intStartValue = 1000; // 시작값
    private static int intEndValue   = 9999; // 종료값
    private static int intCrrntValue = 1000; // 현재값
	
	// ID 가져오기
    public static synchronized String getId()
    {
        final int intSffx = intCrrntValue; // 출력접미사

        intCrrntValue++;
        if ( intCrrntValue >= ( intEndValue + 1 ) ) intCrrntValue = intStartValue;

        return System.currentTimeMillis() + "_" + intSffx; // 리턴 처리
    }
}
