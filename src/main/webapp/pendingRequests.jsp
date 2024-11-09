<!DOCTYPE html>
<html lang="en">
<head><title>Pending Requests</title></head>
<body>
    <!-- List of pending requests with approve/reject options -->
    <form action="pendingRequests" method="post">
        Request ID: <input type="text" name="requestId"><br>
        <button name="action" value="approve">Approve</button>
        <button name="action" value="reject">Reject</button>
    </form>
</body>
</html>
