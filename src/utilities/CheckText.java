/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

/**
 *
 * @author Nong_Tien_Son
 */
public class CheckText {
    public static boolean checkAtExists(String str) {
        return str.contains("@");
    }
    public static String removeAt(String str) {
        return str.replace("@", "");
    }
    
    public static String getFirstWordBeforeSpace(String text) {
        // Tách chuỗi thành các phần tử dựa trên khoảng trắng
        String[] parts = text.split("\\s+");
        
        // Kiểm tra xem có ít nhất một phần tử sau khi tách chuỗi không
        if (parts.length > 0) {
            // Trả về phần tử đầu tiên
            return parts[0];
        } else {
            // Trả về chuỗi rỗng nếu không có phần tử nào sau khi tách
            return "";
        }
    }
}
