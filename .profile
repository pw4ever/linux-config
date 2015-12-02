source /etc/profile 

# help functions
function my_join { local IFS="$1"; shift; echo "$*"; }

#export TERM=xterm
export EDITOR=gvim

# aliases
alias ls="ls --color=auto"
alias grep="grep --color=auto"
alias open="xdg-open"
alias prime='DRI_PRIME=1'

# local bin
export PATH="$HOME/bin:$PATH"

# homedir local installations (for scenario without the root privilege)
export PATH="$HOME/local/bin:$HOME/usr/$(uname -m)/bin:$HOME/usr/bin:$PATH"
export LD_LIBRARY_PATH="$HOME/local/lib:$HOME/usr/$(uname -m)/lib:$HOME/usr/lib:$LD_LIBRARY_PATH"
export CPATH="$HOME/local/include:$HOME/usr/$(uname -m)/include:$HOME/usr/include:$CPATH"
export MANPATH="$HOME/local/share/man:$HOME/usr/$(uname -m)/share/man:$HOME/usr/share/man:$MANPATH:$(manpath)"

# ccache
export PATH="/usr/lib/ccache/bin/:$PATH"
export CCACHE_PATH="/usr/bin"
export CCACHE_DIR="$HOME/.ccache"

# go
MY="$HOME/go"
[[ -d "$MY" ]] || mkdir -p "$MY"
if [[ "x$GOPATH" == "x" ]]; then
  export GOPATH="$MY"
else
  export GOPATH="$MY:$GOPATH"
fi
export PATH="$MY/bin:$PATH"
unset MY

# local Perl5
export PERL5LIB="$HOME/perl:$HOME/perl/lib/perl5:$PERL5LIB"
export PATH="$HOME/perl/bin:$PATH"

# local Ruby
#PATH="$(ruby -e 'print Gem.user_dir')/bin:$PATH"
#export rvm_ignore_gemrc_issues=1

# default browser
export BROWSER="firefox"

# android SDK
android_sdk_root=$HOME/android-sdk
export PATH=${android_sdk_root}/tools:${PATH}
export PATH=${android_sdk_root}/platform-tools:${PATH}
# MANUAL: create a symlink from "latest" to concrete path
export PATH=${android_sdk_root}/build-tools/latest:${PATH}
unset android_sdk_root

# linux kernel hacking helper
export PATH="$HOME/hacking/linux-kernel/helper:$PATH"
export ARENA="$HOME/arena/linux/"

# Haskell cabal
export PATH="$HOME/.cabal/bin:$PATH"

# Clojure
# https://github.com/technomancy/leiningen/wiki/Faster
export LEIN_FAST_TRAMPOLINE=1
#export LEIN_JVM_OPTS=  # disable tiered compilation, do full optimization; good for long running processes

# YourKit Java Profile
export PATH="$PATH:$HOME/yjp/bin/"

# https://wiki.archlinux.org/index.php/Metasploit_Framework#Setting_up_the_database
alias msfconsole="msfconsole --quiet -x \"db_connect ${USER}@msf\""

# GNU Global 
export GTAGSLABEL=pygments

[[ -s "$HOME/.rvm/scripts/rvm" ]] && source "$HOME/.rvm/scripts/rvm" # Load RVM into a shell session *as a function*

# Leiningen
export LEIN_ROOT="1"  # allow root to use Leiningen

# Node.js Version Manager
export NVM_DIR="$HOME/.nvm"
[ -s "$NVM_DIR/nvm.sh" ] && . "$NVM_DIR/nvm.sh"  # This loads nvm
