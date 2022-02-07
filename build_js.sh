#!/usr/bin/env bash
set -euo pipefail

./gradlew client:jsBrowserWebpack

cp -r client/build/distributions/* docs
du -sh docs/*
