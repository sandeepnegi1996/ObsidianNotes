# Obsidian Sync 
- I use this script for the obsidian vault sync to github so that i can directly push all my notes to github with just one click and can use the same notes in all the different devices although i just have two device but it is cool fix. :) 

## Steps
1. Create a simple bash script sync.sh
2. Paste the code 
```

#!/bin/bash

gstatus=`git status --porcelain`

if [ ${#gstatus} -ne 0 ]
then

    git add --all
    git commit -m "$gstatus"

        git pull
    git push

fi

```

3. run the bash script  !! voila 