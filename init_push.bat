cd /d "%~dp0"
git init
git add *
git commit -a -m "version initiale"
git remote add gitHubOriginAfcepfcdiWeb https://didier-tp:pwd007!@github.com/didier-tp/afcepf_cdiWeb.git
git push -u gitHubOriginAfcepfcdiWeb master
pause

REM open with text editor
REM opne with system editor