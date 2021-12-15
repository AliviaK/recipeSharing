<header>
    <h3>Send Party Invite: </h3>
</header>

<form method="post" action="dispatch-email">
    <table>
        <tr>
            <td>Invite: </td>
            <td><input type="text" id="email" name="email" maxlength="75"></td>
        </tr>
        <tr>
            <td>Subject: </td>
            <td><input type="text" id="subject" name="subject" maxlength="75"></td>
        </tr>
        <tr>
            <td>Message: </td>
            <td><textarea id="message" name="message" maxlength="75" rows="3"></textarea></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="send"></td>
        </tr>
    </table>
</form>