echo off
echo [Start FileCopy] %time% > filecopy.log
FOR /F "tokens=1,2,3 delims=," %%a IN (filecopy.csv) DO (
	copy "%%a" "%%b"
	copy "%%a" "%%c"
	echo pathFrom: %%a → pathTo: %%b >> filecopy.log
	echo pathFrom: %%a → pathTo: %%c >> filecopy.log
	@rem explorer "%%a"
)
echo [End FileCopy] %time% >> filecopy.log