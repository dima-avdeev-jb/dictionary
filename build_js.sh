#!/usr/bin/env bash
set -euo pipefail

./gradlew client:jsBrowserWebpack

rm -rf docs
mkdir docs
cp -r client/build/distributions/* docs
du -sh docs/*
