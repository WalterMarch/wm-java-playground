# Java

**Java** is a popular, general purpose, high-level language. It is often the go-to language for learning or teaching Object Oriented Programming. Among other things, it is used for mobile and web development.

## File Extension

`.java`

## Compile

```bash
cd <path/to/file>
javac <filename>.java
```

## Execute

Assuming the current working directory is `<path/to/file>`:

```bash
java <filename>
```

## configit.sh

This repository's *devcontainer.json* uses a `postCreateCommand` to run `configit.sh`.

This script uses information particular to the user of the repository.

```shell
#!/bin/bash

git config --global user.email "yourEmail@mail.com"
git config --global user.name "yourGitUserName"
git config --global push.autoSetupRemote true
git config --global push.default current
git config --global init.defaultBranch main
git config --global --add safe.directory $1
```
