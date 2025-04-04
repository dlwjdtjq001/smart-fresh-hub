package user.controller;
import user.dto.UserDTO;
import user.service.UserService;

import java.sql.SQLException;
import java.util.Scanner;

public class AdminContImpl implements AdminCont {

    private final UserService userService;
    private static final Scanner sc = new Scanner(System.in);
    public AdminContImpl(UserService userService) {
        this.userService = userService;
    }


    @Override
    public void createUser() {
        UserDTO newUser = UserInputHelper.getDtoFromUserInfo(); // 사용자 입력값을 받아서,
        userService.createUser(newUser); // 서비스계층에게 넘기기
        // 성공 메시지 추가하기
    }

    @Override
    public void findUser() {
        String userLoginId = UserInputHelper.inputUserLoginId();
        userService.findUser(userLoginId);

    }

    @Override
    public void updateUser() throws SQLException {
        String userLoginId = UserInputHelper.inputUserLoginId();

        System.out.println("===== 회원 정보 수정 메뉴 =====");
        System.out.println("1. 비밀번호 변경");
        System.out.println("2. 주소 변경");
        System.out.println("3. 이름 변경");
        System.out.println("4. 이메일 변경");
        System.out.println("5. 전화번호 변경");
        System.out.println("6. 생년월일 변경");
        System.out.println("7. 사용자 유형 변경");
        System.out.print("변경할 항목의 번호를 선택하세요: ");

        int choice = sc.nextInt();


        UserDTO fetchedUser = userService.findUser(userLoginId);
        userService.updateUser(fetchedUser, choice);

    }

    @Override
    public void deleteUser() {
        String userLoginId = UserInputHelper.inputUserLoginId();
        userService.deleteUser(userLoginId); // 서비스계층에게 넘기기
    }
}
