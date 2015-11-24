#!/bin/bash - 

## https://stackoverflow.com/questions/59895/can-a-bash-script-tell-what-directory-its-stored-in
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"

## oh my zsh
wget --no-check-certificate http://install.ohmyz.sh -O - | sh
cp ${DIR}/.zshrc ~
cp ${DIR}/.profile ~

## vim
cp -r ${DIR}/.vim ${DIR}/.vimrc ~

## lein
cp -r ${DIR}/tools ~

## tmux
cp -r ${DIR}/.tmux.conf ~

## leiningen
cp -r ${DIR}/.lein ~

## conky
cp -r ${DIR}/.conkyrc ~ 

## mplayer
cp -r ${DIR}/.mplayer ~ 
