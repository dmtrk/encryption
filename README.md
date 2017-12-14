# encryption
Examples of using encryption in java

## Build/Release
Release task and version generation is handled by 'pl.allegro.tech.build.axion-release' plugin.<br/>
axion-release plugin will guess the next version number based on tags in git.

To make a release commit all changes to 'develop' branch and execute git push to push you updates to remote git.
Next switch to 'master' branch, merge from 'develop' to 'master' and perform a release:

`git checkout master`<br/>
`git merge develop`<br/>
`./gradlew release` or `./gradlew release -Prelease.forceVersion=3.0.0`<br/>
