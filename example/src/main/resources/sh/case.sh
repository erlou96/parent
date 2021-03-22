#!/bin/bash
#case select
echo -n "Enter a num form 1 to 3:"
read ANS
case $ANS in

1)
        echo "you select 1 ..."
        ;;

2)
        echo "you select 2 ..."
        ;;

3)
        echo "you select 3 ..."
        ;;
*)
        echo "`basename $0` : this is not between 1 and 3"
        exit;
        ;;
esac