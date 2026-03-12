echo "Step 1: Clean Build"
mvn clean install


#This would start Spring boot app and activates blue profile
echo "Step 2: Start app in Blue profile"
mvn spring-boot:run -Dspring-boot.run.profiles=blue

if [ $? -eq 0 ]; then
 echo "Migration successful - switch to BLUE"
else
 echo "Migration failed - revert to GREEN"
fi

echo "Pipeline completed"