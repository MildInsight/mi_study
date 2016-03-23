package org.hhr.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.hhr.example.vo.ScoresVO;

public class Callbyreference {
	
	public static void main(String...args) {
		new Callbyreference().run();
	}
	
	public void run() {
		System.out.println("### swap start ###");
		int[] a = new int[]{1};
		int[] b = new int[]{2};
		System.out.println(" a = "+ a[0] + ", b = "+b[0]);
		System.out.println(" swap! ");
		swap(a, b);
		System.out.println(" a = "+ a[0] + ", b = "+b[0]);
		System.out.println("### swap end   ###");
		System.out.println();

		System.out.println("### addArgs start ###");
		String[] args = new String[]{" Say Hello "};
		System.out.println(args[0]);
		System.out.println(" addArgs! ");
		addArgs(args);
		System.out.println(args[0]);
		System.out.println("### addArgs end   ###");
		System.out.println();

		System.out.println("### getDataMap start ###");
		Map<String, String[]> result = getDataMap();
		Iterator<String> iter = result.keySet().iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			System.out.println("key : " + key);
			System.out.print("values : ");
			for(String value : result.get(key)) {
				System.out.print(value+" ");
			}
			System.out.println();
		}
		System.out.println("### getDataMap end   ###");
		System.out.println();

		System.out.println("### calcTotalData start ###");
		Map<String,double[]> totalMap = calcTotalData();
		System.out.println("성명\t국어\t영어\t수학\t사회\t과학\t총점\t평균");
		Iterator<Entry<String, double[]>> entryIter = totalMap.entrySet().iterator();
		while(entryIter.hasNext()) {
			Entry<String, double[]> entry = entryIter.next();
			System.out.print(entry.getKey());
			for(double score : entry.getValue()) {
				System.out.print("\t"+score);
			}
			System.out.println();
		}
		System.out.println("### calcTotalData end   ###");
	}
	
	public void swap(int[] a, int[] b) {
		int temp = a[0];
		a[0] = b[0];
		b[0] = temp;
	}

	public void addArgs(String[] arg) {
		arg[0] += " Mr.Ham ! ";
	}
	
	public Map<String, String[]> getDataMap() {
		Map<String, String[]> resultMap = new HashMap<String, String[]>();
		
		String[] resultArray = new String[3];
		resultMap.put("result", resultArray);

		resultArray[0] = " Hello ";
		resultArray[1] = " Mr. ";
		resultArray[2] = " Ham ";
		
		return resultMap;
	}
	
	// Map의 key=이름, value = 국어점수,영어점수,수학점수,사회점수,과학점수,총점,평균점수
	// 개인 점수와 통계를 출력
	public Map<String, double[]> calcTotalData() {
		
		Map<String, double[]> totalMap = new TreeMap<String, double[]>();
		double[] sum = new double[7];
		totalMap.put("6.반 총점", sum);
		double[] ave = new double[7];
		totalMap.put("7.반 평균", ave);
		
		List<ScoresVO> testResultList = getTestResult();
		
		int count = 0;
		for(ScoresVO testResult : testResultList) {
			String key = (++count)+"."+testResult.getName();
			
			double[] scores = new double[]{testResult.getKorean(), testResult.getEnglish(), testResult.getMath(), testResult.getSociety(), testResult.getScience()
					, testResult.calcSum(), testResult.calcAve()};
			// 개인점수 저장
			totalMap.put(key, scores);
			
			// 클래스 총점 계산
			for(int i = 0; i < sum.length; i++) {
				sum[i] += scores[i];
			}
		}
		
		// 클래스 평균점수 계산
		for(int index = 0; index < ave.length; index++) {
			ave[index] = sum[index] / count;
		}
		
		return totalMap;
	}
	
	private List<ScoresVO> getTestResult() {
		
		List<ScoresVO> testResultList = new ArrayList<ScoresVO>(5);

		testResultList.add(new ScoresVO("jk", 82, 96, 90, 76, 94));
		testResultList.add(new ScoresVO("hue", 80, 82, 100, 76, 84));
		testResultList.add(new ScoresVO("jin", 77, 90, 100, 70, 100));
		testResultList.add(new ScoresVO("csi", 90, 100, 85, 90, 45));
		testResultList.add(new ScoresVO("hhr", 100, 90, 80, 70, 85));
		
		return testResultList;
	}
	
}
