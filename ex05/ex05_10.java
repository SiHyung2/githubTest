package ex05;
abstract class PairMap{
	protected String keyArray[];
	protected String valueArray[];
	abstract String get(String key);
	abstract void put(String key, String value);
	abstract String delete(String key);
	abstract int length();
}
class Dictionary extends PairMap{
	private int key_and_value_index=0;
	
	Dictionary(int k){
		String kA[]=new String[k];
		String vA[]=new String[k];
		super.keyArray=kA;
		super.valueArray=vA;
	}

	@Override  //key 값으로 value 를 검색
	String get(String key) {
		for(int i=0;i<keyArray.length;i++) {
			if(keyArray[i]==key) {
				return valueArray[i];
			}
		}
		return null;
	}

	@Override   // key 와 value 를 쌍으로 저장
	void put(String key, String value) {
		keyArray[key_and_value_index]=key;
		valueArray[key_and_value_index]=value;
		key_and_value_index++;
	}
 
	@Override
	String delete(String key) {
		for(int i=0;i<keyArray.length;i++) {
			if(keyArray[i]==key) {
				keyArray[i]=null;
				valueArray[i]=null;
			}
		}
		return null;
	}

	@Override
	int length() {
		int dic_size=0;
		for(int i=0;i<keyArray.length;i++) {
			if(keyArray[i]!=null) {
				dic_size++;
			}
		}
		return dic_size;
	}
	
}


public class ex05_10 {
	public static void main(String[] args) {
		Dictionary dic=new Dictionary(10);
		dic.put("손흥민","축구");
		dic.put("아이유", "가수");
		dic.put("아이유", "배우");
		
		System.out.println("아이유의 값은"+dic.get("아이유"));
		System.out.println("손흥민의 값은"+dic.get("손흥민"));
		dic.delete("손흥민");
		System.out.println("손흥민의 값은"+dic.get("손흥민"));
		
//		System.out.println("dic_size :"+dic.length());     //테스트 용 코드
	}
}
