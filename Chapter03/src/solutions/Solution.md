# Compile
javac -d . HelloJar.java

# Create JAR (automatically creates META-INF/MANIFEST.MF)
jar -cvfe hello.jar HelloJar *.class

# Extract and view auto-generated manifest
jar -xf hello.jar META-INF/MANIFEST.MF

cat META-INF/MANIFEST.MF

# Run
java -jar hello.jar

# View META-INF contents without extracting:

# List all files in JAR including META-INF
jar -tf hello.jar

# View manifest directly (without extracting)
unzip -p hello.jar META-INF/MANIFEST.MF