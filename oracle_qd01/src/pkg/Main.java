package pkg;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String userid = "";
		String username = "";
		int yearRank = 0;
		String position = "";
		try  {
			while (true) {
				System.out.println("[ 사원관리 프로그램 ] ");
				System.out.print("1. 사원목록 2.사원등록 3.직위수정 4.자료삭제 5.종료 ");
				System.out.print("\n\n메뉴를 선택하세요 : ");
				int type = sc.nextInt();
				System.out.println();
				if (type == 1) {				
					StaffList stlist = new StaffList();
					stlist.seleteStaff();
					
				} else if (type == 2) {
					System.out.println("사원등록");
					System.out.println("--------------------------");
					System.out.print("아이디를 입력하세요 : ");
					userid = sc.next();
					System.out.print("이름을 입력하세요 : ");
					username = sc.next();
					System.out.print("년차를 입력하세요 : ");
					yearRank = sc.nextInt();
					System.out.print("직위를 입력하세요 : ");
					position = sc.next();
					StaffAdd  add = new StaffAdd(userid, username, yearRank, position);
					add.insertStaff();
					
				} else if (type == 3) {
					System.out.print("수정할 직원의 번호를 입력하세요 : ");
					userid = sc.next();
					System.out.print("수정할 직위를 입력하세요 : ");
					position = sc.next();
					StaffModify modify = new StaffModify(userid, position);
					modify.updateStaff();
					
				} else if (type == 4) {
					System.out.print("퇴사할 사원의 번호를 기재하세요 :");
					int usernum = sc.nextInt();
					StaffDelete delete = new StaffDelete(usernum);
					delete.removeStaff();
					
				} else if (type == 5) {
					System.out.println("사원관리 프로그램 종료!");
					System.exit(0);
					
				} else {
					System.out.println("잘못눌렀네 다시 눌러보렴");
					
				}

			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		sc.close();

	}

}
