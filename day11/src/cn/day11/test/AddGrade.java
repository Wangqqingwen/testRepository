package cn.day11.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

import javax.sound.sampled.Line;

public class AddGrade {
	public static void main(String[] args) throws IOException {
		//从键盘输入
		InputStream in = System.in;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		
//		OutputStream out = System.out;
//		
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		
		String readLine = br.readLine();
		
		TreeSet<Student> treeSet = new TreeSet<>(new MyComparator());
		
		while(readLine!=null){
			if(readLine.equals("over")){
				break;
			}
			String[] sp = readLine.split(",");
			//System.out.println(sp.length);
			String name = sp[0];
			int score1 = Integer.parseInt(sp[1]);
			int score2 = Integer.parseInt(sp[2]);
			int score3 = Integer.parseInt(sp[3]);
			int sumscore = score1+score2+score3;
			
			Student student = new Student(name, score1, score2, score3,sumscore);
			
			treeSet.add(student);
			readLine = br.readLine();
		}
		
		Iterator<Student> it = treeSet.iterator();
		
		/*while(it.hasNext()){
			System.out.println(it.next());
		}*/
			
		FileOutputStream output = new FileOutputStream("score.txt", true);
		
		while(it.hasNext()){
			Student a = it.next();
			String text = "("+a.getName()+","+a.getScore1()+","+a.getScore2()+","+a.getScore3()+")总分为："+a.getSumscore()+"\n";
			output.write(text.getBytes());
		}
		
		System.out.println("写入成功");	
			
	}
}

class Student{
	private String name;
	private int score1;
	private int score2;
	private int score3;
	private int sumscore;
	
	public Student() {
	
	}
	public Student(String name, int score1, int score2, int score3,int sumscore) {
		
		this.name = name;
		this.score1 = score1;
		this.score2 = score2;
		this.score3 = score3;
		this.sumscore = sumscore;
	}
	public int getSumscore() {
		return sumscore;
	}
	public void setSumscore(int sumscore) {
		this.sumscore = sumscore;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore1() {
		return score1;
	}
	public void setScore1(int score1) {
		this.score1 = score1;
	}
	public int getScore2() {
		return score2;
	}
	public void setScore2(int score2) {
		this.score2 = score2;
	}
	public int getScore3() {
		return score3;
	}
	public void setScore3(int score3) {
		this.score3 = score3;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "{"+this.name+","+this.score1+","+this.score2+","+this.score3+","+this.sumscore+"}";
	}
}

class MyComparator implements Comparator<Student>{

	@Override
	public int compare(Student stu1, Student stu2) {
		int sum1 = stu1.getScore1()+stu1.getScore2()+stu1.getScore3();
		int sum2 = stu2.getScore1()+stu2.getScore2()+stu2.getScore3();
		return sum2-sum1;
	}
	
}
