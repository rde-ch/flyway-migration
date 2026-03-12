echo "Step 1: Clean Build"
mvn clean install


#This would start Spring boot app and activates Green profile
echo "Step 2: Start app in Green profile"
mvn spring-boot:run -Dspring-boot.run.profiles=green

if [ $? -eq 0 ]; then
 echo "Migration successful - switch to GREEN"
else
 echo "Migration failed - revert to BLUE"
fi

echo "Pipeline completed"




