
Option Explicit
Dim objWshShell     ' WshShell オブジェクト
Dim strPath
Dim idx
Dim InstallPath
Dim objFSO
Dim fil
Dim wPathStrings
Dim wFile

Set objWshShell = WScript.CreateObject("WScript.Shell")
If Err.Number = 0 Then
wPathStrings = objWshShell.ExpandEnvironmentStrings("%PATH%")
' WScript.Echo  wPathStrings
    strPath = Split(wPathStrings,";")
Else
    WScript.Echo "エラー: " & Err.Description
    WScript.Quit
End If

For idx = 0 to UBound(strPath)
If (instr(1, LCase(strPath(idx)), "\product\11") > 0) Then
InstallPath = strPath(idx)
Exit For
End If
Next

IF (InstallPath = "") Then
WScript.Echo "Oracleのインストールフォルダが見つかりませんでした。"
WScript.Quit
End If

IF (Right(InstallPath,1) = "\") Then
InstallPath = Left(InstallPath, Len(InstallPath) - 1)
End If

Do
IF right(InstallPath, 1) = "\" Then
InstallPath = InstallPath & "network\admin\"
Exit Do
End If
InstallPath = Left(InstallPath, Len(InstallPath) - 1)
Loop

Set objFSO = WScript.CreateObject("Scripting.FileSystemObject")

IF not objFSO.FolderExists(InstallPath) then
WScript.Echo "フォルダーが見つかりません:" & vbcrlf & InstallPath
WScript.Quit
End if

IF not objFSO.FileExists("Y:\990_PC設定関連\設定ファイル\oracle\" & "tnsnames.ora") then
WScript.Echo "TNSNAMESのファイルがありません:" & vbcrlf & "Y:\990_PC設定関連\設定ファイル\oracle\" & "tnsnames.ora"
WScript.Quit
End if 

IF objFSO.FileExists(InstallPath & "tnsnames.ora") then

For Each wFile In objFSO.GetFolder(InstallPath).Files
If Instr(1,wFile.Name,"tnsnames",1) >= 1 Then
wFile.Delete
End If
Next
' Set fil = objFSO.GetFile(InstallPath & "tnsnames.ora")
' idx = 1
' Do
' IF not objFSO.FileExists(InstallPath & "tnsnames_" & idx & ".ora") then
' Set fil = objFSO.GetFile(InstallPath & "tnsnames" & ".ora")
' fil.Move(InstallPath & "tnsnames_" & idx & ".ora")
' 
' Exit Do
' End If
' 
' idx = idx + 1
' Loop
Else
WScript.Echo "TNSNAMESのファイルがありません:" & vbcrlf & InstallPath & "tnsnames.ora"
WScript.Quit
end if


Set fil = objFSO.GetFile("Y:\990_PC設定関連\設定ファイル\oracle\" & "tnsnames.ora")

fil.Copy(InstallPath)

WScript.Echo "コピー完了"



Set objWshShell = Nothing

