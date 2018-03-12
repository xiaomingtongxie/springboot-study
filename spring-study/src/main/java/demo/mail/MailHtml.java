package demo.mail;

public class MailHtml {

    public static String getMailHtml(String date,String sub,String content){
        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">")
                .append("<html>")
                .append("<head>")
                .append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">")
                .append("<title>邮件</title>")
                .append("<style type=\"text/css\">")
                .append("table{width:100%;height:100%;border-collapse:collapse;border:none;}")
                .append("table td{border:solid gray 1px;}")
                .append(".td_1{width:20%;text-align:center;background-color:#cce8cf;}")
                .append("</style>")
                .append("</head>")
                .append("<body>")
                .append("<table>")
                .append("<tr style='height:15%;'><td class=\"td_1\">时间</td><td>"+date+"</td></tr>")
                .append("<tr style='height:15%;'><td class=\"td_1\">标题</td><td>"+sub+"</td></tr>")
                .append("<tr><td class=\"td_1\">内容</td><td>"+content+"</td></tr>")
                .append("</table>")
                .append("</body>")
                .append("</html>");
        return sb.toString();
    }

    private MailHtml() {
        throw new IllegalAccessError("MailHtml class");
    }
}
