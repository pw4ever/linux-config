#!/bin/sh

# create directories
cd $HOME
mkdir -p $HOME/hacking/common-lisp/

# set up environment
cd $HOME/hacking/
git clone https://github.com/pw4ever/dev-env.git && cp -r dev-env/{.emacs*,.sbclrc,.config,quicklisp,tools} ~
perl -wpli -e 's/^;(.+(?:general|autocomplete|color-theme|anything|slime|paredit).*$)/$1/' ~/.emacs
