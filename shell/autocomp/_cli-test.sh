#compdef cli-test.sh
# filename: _cli-test.sh
# zsh

_cli_test() {

    _arguments -C -s -S \
               '-h::' \
               '-u::' \
               '-d:auto complete date:__complete_d_option' \
               '-p::'
}

__complete_d_option() {
    local expl
    dates=( `generate_date` )

    _wanted dates expl date compadd $* - $dates
}

generate_date() {
    date -v -3d +"%Y-%m-%d"
    date -v -2d +"%Y-%m-%d"
    date -v -1d +"%Y-%m-%d"
    date +"%Y-%m-%d"
    date -v +1d +"%Y-%m-%d"
    date -v +2d +"%Y-%m-%d"
    date -v +3d +"%Y-%m-%d"
}

_cli_test "$@"